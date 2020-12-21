package com.rocship.alisecurity.config.shiro;/**
 * Description: <br/>
 * date: 2020/12/21 11:46<br/>
 *
 * @version
 */

import org.apache.shiro.mgt.SubjectDAO;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserSubjectDAO <br/>
 * Description: <br/>
 * date: 2020/12/21 11:46<br/>
 * @author 15438<br />
 */

@Component
public class UserSubjectDAO implements SubjectDAO {


    @Override
    public Subject save(Subject subject) {

        System.out.println(String.valueOf(subject));


        return null;

    }

    @Override
    public void delete(Subject subject) {
        System.out.println(String.valueOf(subject));
    }
}
