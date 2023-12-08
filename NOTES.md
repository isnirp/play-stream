# Thread
- java.lang.Thread
- thread of execution in a program
- a lightweight process that performs a task
- threads are mapped to system level threads

## creating thread
- extending Thread class
- implementing Runnable interface
- to run;
  - t.start() *//start() calls the run() method*
- methods
  - Thread.currentThread() *//returns ref to instance of the executing thread*
  - Thread.sleep(1000L) *// throws InterruptedException*

## lifecycle of thread
- new state
  - thread is created
- runnable
  - thread is ready for execution
  - thread is awaiting the processor's availability
- running
  - the thread has hold of the processer
  - run()
- blocked
  - thread is inactive as a result of an IO
  - sleep()
- dead
  - stop()

## thread priority
- Threads have priority ranging from 1 to 10
- Thread.MIN_PRIORITY
- Thread.NORM_PRIORITY
- Thread.MAX_PRIORITY

## virtual threads
- java 19

## threadpool
- controls the number of threads the program creates
- Executors
  - Executors.newSingleThreadExecutor()
  - Executors.newFixedThreadPool(10)
  - Executors.newCachedThreadPool(10)
  - Executors.newScheduledThreadPool(10)
- Executor
  - execute(r)
- ExecutorService
  - submit(r)
- ThreadPoolExecutor
- ForkJoinPool
  - java 7

## critical section

## race condition

## deadlock

## thread safety
- stateless impl
- immutability
- synchronized Collections
- ConcurrentHashMap
- Atomic Objects
  - AtomicInteger
  - AtomicLong
  - AtomicBoolean
  - AtomicReference
- synchronized methods
  - one thread accesses the method at a time
  - relies on intrinsic or monitor locks of an object
- synchronized statement
  - synchronized(this){}
- volatile fields
  - makes field visible to other threads
  - field is stored in main memory
- Reentrant locks
  - suitable for queued threads
  - new ReentrantLock(true)
  - lock()
  - unlock()
- ReentrantReadWriteLock
  - new ReentrantReadWriteLock()
  - readLock()
  - writeLock()

