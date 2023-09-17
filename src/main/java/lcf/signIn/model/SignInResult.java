package lcf.signIn.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 签到结果
 */
@Setter
@Getter
public class SignInResult {

    /** 是否成功 */
    private boolean success;

    /** 提示 */
    private String tips;

}
