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
                Class cl = Class.forName("com.sanicbeats.Runtime", true, loader);

                //Create a object via C# reflection
                Type = ikvm.runtime.Util.getInstanceTypeFromClass(cl);

                //Class cl = typeof(com.sanicbeats.Runtime);
                //Thread.currentThread().setContextClassLoader(cl.getClassLoader());
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

            //object result = null;
            //switch(method)
            //{
            //    case "transform1":
            //        result = com.sanicbeats.Runtime.transform1(data);
            //        break;
            //    case "transform2":
            //        result = com.sanicbeats.Runtime.transform2(data);
            //        break;
            //    case "transform3":
            //        result = com.sanicbeats.Runtime.transform3(data);
            //        break;
            //    case "transform4":
            //        result = com.sanicbeats.Runtime.transform4(data);
            //        break;
            //    case "transform1Complex":
            //        result = com.sanicbeats.Runtime.transform1Complex(data);
            //        break;
            //    case "transform2Complex":
            //        result = com.sanicbeats.Runtime.transform2Complex(data);
            //        break;
            //    case "transform3Complex":
            //        result = com.sanicbeats.Runtime.transform3Complex(data);
            //        break;
            //    case "transform4Complex":
            //        result = com.sanicbeats.Runtime.transform4Complex(data);
            //        break;

            //}
            var methodInstance = Type.GetMethod(method, new Type[] { typeof(byte[]) });
            var result = methodInstance.Invoke(null, new object[] { data });

            if (result is byte[] resultData)
                return resultData;
            throw new Exception("The invokation of a java object failed.");
        }

    }
}
