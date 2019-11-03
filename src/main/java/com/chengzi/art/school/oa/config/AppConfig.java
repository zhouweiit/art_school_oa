package com.chengzi.art.school.oa.config;

public class AppConfig {

    public static class Login {
        public static final int sessionTimeout = 60 * 30;
        public static final String isLoginSessionKey = "_is_login_";
        public static final String userIdSessionKey = "_user_base_id_";
        public static final String captchaSessionKey = "_captcha_";
        public static final int captchaWidth = 110;
        public static final int captchaHeight = 35;
    }

}
