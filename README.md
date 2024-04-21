## 《图解Java多线程设计模式》

### 基础知识

#### 串行、并行与并发

- 串行：表示多个操作被 **依次处理**，比如把 10 个操作交给一个人处理时，这个人要一个一个地处理
- 并行：表示多个操作被 **同时处理**，比如把 10 个操作交给 10 个人处理，每个人处理一个操作
- 并发：相对于串行和和并行比较抽象，它用于表示“将一个操作分割成多个部分并且允许无序处理”。比如将 6 个操作分成相对独立的两类，这样便能够开始并发处理了，如下图所示为并发处理的串行执行和并行执行：

![串行、并行与并发.png](src/main/resources/images/串行、并行与并发.png)

#### synchronized 关键字

在Java中，synchronized 关键字可以用来给对象和方法加锁。当一个线程访问 syncronized 修饰的方法或代码块时，它会自动获取锁，其他线程则必须等待该线程释放锁后才能获取锁来访问被保护的代码段。如果一个对象有两个被 synchronized 标记的不同方法，那么这两个方法共享同一个对象锁。因此，如果一个线程正在执行其中一个 synchronized 方法，其他线程不能同时执行这两个方法中的任何一个，它们必须等待第一个线程释放锁，这是因为 synchronized 关键字在**对象级别**上添加了一个互斥锁（或监视器锁）。当一个线程获取了对象的锁，其他线程无法通过，直到锁被释放。

- eg: life.fangyuan.juc.common.Test.test01