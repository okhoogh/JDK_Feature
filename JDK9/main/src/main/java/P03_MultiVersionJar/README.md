## 多版本兼容Jar包
> 多版本JAR（MR JAR）可能包含同一类的多个变体,每个变体都针对特定的Java版本。 在运行时，类的正
确变体将被自动加载，这取决于所使用的Java版本。这允许库作者在早期利用新的Java版本，同时保持
与旧版本的兼容性。
> 
> 应用场景：比如开发了一个工具类MyUtils,该工具类里面使用了jdk9的新特性，这时候该工具在推广的时候会遇到很大的阻力，因为很多用户还没有升级jdk版本，JDK9推出了多版本兼用jar的特性就允许编写一个同类名的工具MyUtils,并在该工具类中不使用jdk9的新特性，然后两个同类名的类一起打包成为一个jar，提供给用户去使用,这时候即可根据用户当前使用的jdk版本而选择不同的工具类了。

```shell
javac -d out --release 8 java/com/utils/MyUtil.java
javac -d out9 --release 9 java9/com/utils/MyUtil.java
jar --create --file util.jar -C out . --release 9 -C out9 .
```