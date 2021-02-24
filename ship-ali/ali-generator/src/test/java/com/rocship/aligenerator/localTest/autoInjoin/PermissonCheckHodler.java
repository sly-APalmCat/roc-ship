package com.rocship.aligenerator.localTest.autoInjoin;/**
 * Description: <br/>
 * date: 2021/2/23 16:53<br/>
 *
 * @version
 */

import org.springframework.stereotype.Component;

/**
 * ClassName: PermissonCheckHodler <br/>
 * Description: <br/>
 * date: 2021/2/23 16:53<br/>
 * @author 15438<br />
 */
public interface PermissonCheckHodler {
    public boolean isMatch(String flag);

    public void say();

}

@Component
class OnePermissonCheckHodler implements PermissonCheckHodler{

    @Override
    public boolean isMatch(String flag) {
        if("one".equalsIgnoreCase(flag)){
            return true;
        }
        return false;
    }

    @Override
    public void say() {
        System.out.println("OnePermissonCheckHodler");
    }
}
@Component
class TwoPermissonCheckHodler implements PermissonCheckHodler{

    @Override
    public boolean isMatch(String flag) {
        if("two".equalsIgnoreCase(flag)){
            return true;
        }
        return false;
    }

    @Override
    public void say() {
        System.out.println("TwoPermissonCheckHodler");
    }
}