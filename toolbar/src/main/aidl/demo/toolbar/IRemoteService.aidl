// IRemoteService.aidl
package demo.toolbar;

// Declare any non-default types here with import statements

import demo.toolbar.HelloMsg;

interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


    Hello sayHello();
}
