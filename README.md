# douban-novel-crawler
豆瓣文学小说的爬虫，用到了Quartz和线程池

> 启动类方法：QuartzMaster.runIt(String task,int task_count,String crawler,int thread_count,String cron);

- task:任务模型全路径
- task_count:每次任务量
- crawler:爬虫线程全路径
- thread_count:线程数
- cron:爬取周期
