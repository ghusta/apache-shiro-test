package fr.husta.test;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleTest.class);

    @Before public void setUp() throws Exception {
        log.info("setup()");

        Realm realm = new SimpleAccountRealm("toto");
        SecurityManager securityManager = new DefaultSecurityManager(realm);

        //Make the SecurityManager instance available to the entire application via static memory:
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Test public void simpleTest() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        log.debug("subject : {}", ToStringBuilder.reflectionToString(subject));
    }

}

