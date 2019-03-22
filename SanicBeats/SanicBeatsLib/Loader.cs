using System;
using System;
using Exception = System.Exception;
using java.lang;
using java.net;

namespace SanicBeatsLib
{
    public static class Loader
    {

        public static void LoadJavaLibs()
        {
            URLClassLoader loader = new URLClassLoader(new URL[]{
                new URL("file:SanicBeatsLib.jar"),

            });

            try
            {
                // load the Class
                Class cl = Class.forName("hello.HelloWorld", true, loader);

                // Create a Object via Java reflection
                object obj = cl.newInstance();
                Console.WriteLine(obj);
                obj = cl.getConstructor(typeof(string)).newInstance("Java");
                Console.WriteLine(obj);

                //Create a object via C# reflection
                Type type = ikvm.runtime.Util.getInstanceTypeFromClass(cl);
                obj = type.GetConstructor(new Type[] { }).Invoke(null);
                Console.WriteLine(obj);
                obj = type.GetConstructor(new Type[] { typeof(string) }).Invoke(new object[] { "C#" });
                Console.WriteLine(obj);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Console.WriteLine(ex.StackTrace);
            }
        }

    }
}
