package com.pm.wordi.commons.interceptor;

import com.pm.wordi.commons.annotation.Auth;
import com.pm.wordi.commons.annotation.UnAuth;
import com.pm.wordi.exception.user.CertifiedException;
import com.pm.wordi.exception.user.NotAuthorizedException;
import com.pm.wordi.service.certification.JwtService;
import com.pm.wordi.service.certification.SessionLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {

    private final JwtService jwtService;
    private final SessionLoginService sessionLoginService;

    /**
     * Auth: 관리자 페이지
     * UnAuth: 비인가 페이지
     * 어노테이션이 붙지 않은 페이지는 모두 인가 페이지
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // === 비로그인 시, 인가 처리 ===
        if(request.getHeader("X-ACCESS-TOKEN")==null) {
            if(checkAnnotation(handler, UnAuth.class)) {
                request.setAttribute("userId", 0L);
                return true;
            }
            // TODO: request URI을 바탕으로 redirect 경로 추가.
            throw new CertifiedException("로그인 정보가 없습니다.");
        }

        // === 로그인 시, 인가 처리 ===
        request.setAttribute("userId", jwtService.getUserId());

        // 관리자 페이지
        if(checkAnnotation(handler, Auth.class)) {
            if(sessionLoginService.checkAuth(jwtService.getUserId(), "관리자")){
                return true;
            }
            throw new NotAuthorizedException("해당 회원은 관리자가 아닙니다.");
        }

        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handlerMethod.getMethodAnnotation(clazz) != null || handlerMethod.getMethodAnnotation(clazz) != null) {
            return true;
        }
        return false;
    }


}
