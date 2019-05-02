using System;
using Exception = System.Exception;
using java.lang;
using java.net;
using System.Reflection;

namespace SanicBeatsLib
{
    public static class Loader
    {

        private static Type Type;
        private static object Instance;
        private static bool IsLoaded;

        private static void LoadJavaLib()
        {
            IsLoaded = true;
            URLClassLoader loader = new URLClassLoader(new URL[]{
                new URL("file:rsc/SanicBeatsLib.jar")
            });
            try
            {
                // load the Class
                Class fftClass = Class.forName("com.sanicbeats.Runtime", true, loader);


                //Create a object via C# reflection
                Type = ikvm.runtime.Util.getInstanceTypeFromClass(fftClass);
                //Instance = Type.GetConstructor(new Type[] { typeof(double), typeof(double) }).Invoke(new object[] { 1.0, 1.0 });
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                Console.WriteLine(ex.StackTrace);
            }
        }

        public static byte[] Transform(string method, byte[] data)
        {
            if (!IsLoaded)
                LoadJavaLib();

            object result = Type.GetMethod(method, BindingFlags.Public | BindingFlags.Static)?
                .Invoke(null, new object[] { data });

            if (result is byte[] resultData)
                return resultData;
            throw new Exception("The invokation of a java object failed.");
        }

    }
}
