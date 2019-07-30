package other;

public class Demo {
	/**1、return 语句的作用

		      (1) return 从当前的方法中退出,返回到该调用的方法的语句处,继续执行

		      (2) return 返回一个值给调用该方法的语句，返回值的数据类型必须与方法的声明中的返回值的类型一致，可以使用强制类型转换来是数据类型一致

		      (3) return 当方法说明中用void声明返回类型为空时，应使用这种格式，不返回任何值。

		2、break语句的作用

		      (1) 只能在循环体内和switch语句体内使用break语句。

		      (2) 当break出现在循环体中的switch语句体内时，其作用只是跳出该switch语句体。

		      (3) 当break出现在循环体中，但并不在switch语句体内时，则在执行break后，跳出本层循环体。

		      (4) 在循环结构中，应用break语句使流程跳出本层循环体，从而提前结束本层循环

		3、continue语句作用

		      (1) continue语句continue语句的一般形式为：continue;

		      (2) 其作用是结束本次循环，即跳过本次循环体中余下尚未执行的语句，接着再一次进行循环的条件判定。

		      (3) 注意：执行continue语句并没有使整个循环终止。在while和do-while循环中，continue语句使得流程直接跳到循环控制条件的测试部分 ，然后决定循环是否继续进行。

		      (4) 在for 循环中，遇到continue后，跳过循环体中余下的语句，而去对for语句中的“表达式3”求值，然后进行“表达式2”的条件测试，

		       最后根据“表达式2”的值来决定for循环是否执行。在循环体内，不论continue是作为何种语句中的语句成分，都将按上述功能执行，这点与break有所不同

		*/
		/**
		 * break:如果是单层循环，当走到break语句时，直接跳出本层循环，当前循环不会再继续下去。
		 * 			如果是多层循环，当走到break语句时，直接跳出本层循环，继续执行外层循环。
		 * 
		 * continue:如果是单层循环，当走到continue语句时，跳出本次循环(即停止执行continue语句以后的代码)，继续下次循环。
		 * 
		 * 
		 */
		 

		public static void main(String[] args)

		{

		testBreak();

		testContinue();

		testReturn();

		}

		static void testBreak()

		{

		for(int i=0;i<10;i++)

		{

		   if(i%2==0)

		   {

		    System.out.println("i="+i);

		   }

		   else

		   {

		    System.out.println("执行了break语句,跳出当前循环!");

		    break;

		   }

		}

		}

		static void testContinue()

		{

		for(int i=0;i<10;i++)

		{

		   if(i%2==0)

		   {

		    System.out.println("没有执行continue语句输出i="+i);

		   }

		   else

		   {

		    System.out.println("执行了Continue语句,跳出当前循环!");

		    continue;

		   }

		}

		}

		static void testReturn()

		{

		for(int i=0;i<10;i++)

		{

		   System.out.println("执行了return语句,直接跳出了当前的testReturn方法!");

		   return;

		}

		}

		

		/*运行结果:

		i=0

		执行了break语句,跳出当前循环!

		没有执行continue语句输出i=0

		执行了Continue语句,跳出当前循环!

		没有执行continue语句输出i=2

		执行了Continue语句,跳出当前循环!

		没有执行continue语句输出i=4

		执行了Continue语句,跳出当前循环!

		没有执行continue语句输出i=6

		执行了Continue语句,跳出当前循环!

		没有执行continue语句输出i=8

		执行了Continue语句,跳出当前循环!

		执行了return语句,直接跳出了当前的testReturn方法!

		*/
}

