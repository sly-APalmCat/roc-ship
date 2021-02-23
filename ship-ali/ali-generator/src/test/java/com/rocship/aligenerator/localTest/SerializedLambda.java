
package com.rocship.aligenerator.localTest;

import com.rocship.aligenerator.localTest.reself.ClassUtils;
import com.rocship.aligenerator.localTest.reself.SerializeUtils;

import java.io.*;
import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public  class SerializedLambda implements Serializable {
    private static final long serialVersionUID = 8025925345765570181L;

    private  Class<?> capturingClass;
    private  String functionalInterfaceClass;
    private  String functionalInterfaceMethodName;
    private  String functionalInterfaceMethodSignature;
    private  String implClass;
    private  String implMethodName;
    private  String implMethodSignature;
    private  int implMethodKind;
    private  String instantiatedMethodType;
    private  Object[] capturedArgs;


    /**
     * 解析lambda表达式
     */
    public static SerializedLambda resolve(AFunctionA<?,?> lambda){
        if(!lambda.getClass().isSynthetic()){
            throw new IllegalArgumentException("不是合成的lambda！");
        }

        try (ObjectInputStream obji = new ObjectInputStream(new ByteArrayInputStream(SerializeUtils.serialize(lambda))){
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                Class<?> aClass = super.resolveClass(desc);
                //此处布尔表达式，todo 注意要区分出两个SerializedLambda
                return aClass == java.lang.invoke.SerializedLambda.class ? SerializedLambda.class : aClass;
            }
        }
        ){
            return (SerializedLambda)obji.readObject();
        }catch (ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException(" happen", e);
        }
    }

    /**
     * Get the name of the class that captured this lambda.
     * @return the name of the class that captured this lambda
     */
    public String getCapturingClass() {
        return capturingClass.getName().replace('.', '/');
    }

    /**
     * Get the name of the invoked type to which this
     * lambda has been converted
     * @return the name of the functional interface class to which
     * this lambda has been converted
     */
    public String getFunctionalInterfaceClass() {
        return functionalInterfaceClass;
    }

    /**
     * Get the name of the primary method for the functional interface
     * to which this lambda has been converted.
     * @return the name of the primary methods of the functional interface
     */
    public String getFunctionalInterfaceMethodName() {
        return functionalInterfaceMethodName;
    }

    /**
     * Get the signature of the primary method for the functional
     * interface to which this lambda has been converted.
     * @return the signature of the primary method of the functional
     * interface
     */
    public String getFunctionalInterfaceMethodSignature() {
        return functionalInterfaceMethodSignature;
    }

    /**
     * Get the name of the class containing the implementation
     * method.
     * @return the name of the class containing the implementation
     * method
     */
    public String getImplClass() {
        return implClass;
    }

    /**
     * Get the name of the implementation method.
     * @return the name of the implementation method
     */
    public String getImplMethodName() {
        return implMethodName;
    }

    /**
     * Get the signature of the implementation method.
     * @return the signature of the implementation method
     */
    public String getImplMethodSignature() {
        return implMethodSignature;
    }

    /**
     * Get the method handle kind (see {@link MethodHandleInfo}) of
     * the implementation method.
     * @return the method handle kind of the implementation method
     */
    public int getImplMethodKind() {
        return implMethodKind;
    }

    /**
     * Get the signature of the primary functional interface method
     * after type variables are substituted with their instantiation
     * from the capture site.
     * @return the signature of the primary functional interface method
     * after type variable processing
     */
    public final String getInstantiatedMethodType() {
        return instantiatedMethodType;
    }

    /**
     * Get the count of dynamic arguments to the lambda capture site.
     * @return the count of dynamic arguments to the lambda capture site
     */
    public int getCapturedArgCount() {
        return capturedArgs.length;
    }

    /**
     * Get a dynamic argument to the lambda capture site.
     * @param i the argument to capture
     * @return a dynamic argument to the lambda capture site
     */
    public Object getCapturedArg(int i) {
        return capturedArgs[i];
    }

//    private Object readResolve() throws ReflectiveOperationException {
//        try {
//            Method deserialize = AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() {
//                @Override
//                public Method run() throws Exception {
//                    Method m = capturingClass.getDeclaredMethod("$deserializeLambda$", SerializedLambda.class);
//                    m.setAccessible(true);
//                    return m;
//                }
//            });
//
//            return deserialize.invoke(null, this);
//        }
//        catch (PrivilegedActionException e) {
//            Exception cause = e.getException();
//            if (cause instanceof ReflectiveOperationException)
//                throw (ReflectiveOperationException) cause;
//            else if (cause instanceof RuntimeException)
//                throw (RuntimeException) cause;
//            else
//                throw new RuntimeException("Exception in SerializedLambda.readResolve", e);
//        }
//    }

//    @Override
//    public String toString() {
//        String implKind=MethodHandleInfo.referenceKindToString(implMethodKind);
//        return String.format("SerializedLambda[%s=%s, %s=%s.%s:%s, " +
//                             "%s=%s %s.%s:%s, %s=%s, %s=%d]",
//                             "capturingClass", capturingClass,
//                             "functionalInterfaceMethod", functionalInterfaceClass,
//                               functionalInterfaceMethodName,
//                               functionalInterfaceMethodSignature,
//                             "implementation",
//                               implKind,
//                               implClass, implMethodName, implMethodSignature,
//                             "instantiatedMethodType", instantiatedMethodType,
//                             "numCaptured", capturedArgs.length);
//    }
    /**
     * @return 字符串形式
     */
    @Override
    public String toString() {
        return String.format("%s -> %s::%s", getFunctionalInterfaceClass(), getImplClass(),
                implMethodName);
    }





}
