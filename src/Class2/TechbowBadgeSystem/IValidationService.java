package Class2.TechbowBadgeSystem;

import Class2.TechbowBadgeSystem.Rules.IValidateRule;

import java.util.List;

/**
 * Created by FLK on 2019-12-27.
 */
public interface IValidationService {
    int getUserSecurityLevel(final String userId);

    int getCheckerSecurityLevel(final String checkerId);

    String getUserCurrentBadgeId(final String userId);

    List<IValidateRule> getCheckerValidationRules(String checkerId);

    //Multiple Rules to Open the door
    UserInfo getUserInfo(final String userId);
}
