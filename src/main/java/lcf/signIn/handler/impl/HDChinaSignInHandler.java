//package lcf.signIn.handler.impl;
//
//import lcf.signIn.constant.PrivateTrackerSite;
//import lcf.signIn.handler.SignInHandler;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.util.EntityUtils;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * 瓷器 签到处理器
// */
//@Component
//public class HDChinaSignInHandler implements SignInHandler {
//
//    @Override
//    public PrivateTrackerSite getSite() {
//        return PrivateTrackerSite.HDChina;
//    }
//
//    @Override
//    public String getURI() {
//        return "https://hdchina.org/plugin_sign-in.php?cmd=signin";
//    }
//
//    @Override
//    public String getCookie() {
//        return "hdchina=f14f1a133a34694fb0234e8e59305bab6f78f0ba02bef1563b20ae471d5f48b6; PHPSESSID=21hcua7dbjd84q23qn0gvs47qt";
//    }
//
//    @Override
//    public String getSuccessTips(CloseableHttpResponse httpResponse, String responseEntity) throws IOException {
//        return responseEntity;
//    }
//
//}
