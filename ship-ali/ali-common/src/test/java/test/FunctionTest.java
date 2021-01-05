package test;/**
 * Description: <br/>
 * date: 2021/1/5 14:10<br/>
 *
 * @version
 */

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * ClassName: FunctionTest <br/>
 * Description: <br/>
 * date: 2021/1/5 14:10<br/>
 * @author 15438<br />
 */
public class FunctionTest {

    @Test
    public void kjk(){
        Object gg = gg((v) -> {
            return v.toString() + 0;
        }, 8);
        System.out.println(gg.toString());


    }

    public Object  gg(Function function,int p){
        Function function1 = function.andThen((s) -> {
            return s.toString() + 3;
        });
        Object apply = function1.apply(9);
        System.out.println(apply.toString());
        return function.apply(p);
    }

}
