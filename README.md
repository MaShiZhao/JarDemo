# JarDemo
Android Studio生成jar包

 http://blog.csdn.net/qq_23547831/article/details/51966166

两种方式

1.创建module-library 
  修改代码自动创建
  在build/intermediates/bundles/release/classes.jar
  
2.在app/build.gradle 

最外层

task makeJar(type: Copy) {

    //删除新目录中存在jar

    delete 'build/libs/jardemo.jar'

    //原jar包

    from('build/intermediates/bundles/release/')

    //新jar

    into('build/libs/')

    //筛选jar包名字

    include('classes.jar')

    //重新命名

    rename('classes.jar', 'myjar.jar')

}

// 下面两个保留一个即可

// build.finalizedBy makeJar

   makeJar.dependsOn(build)

//  在终端执行生成JAR包

// ./gradlew makeJar


注意：
  执行发现在app/build下找不到libs/myjar

  查看原jar是否存在

    如果不存在，并且只有debug包 执行

        ./gradlew clear

        ./gradlew build

    如果只有instant-run 没有aapt manifest classes.jar等

       查看build.gradle里面  plugin: 'com.android.library' 是否是library 还是application



  
