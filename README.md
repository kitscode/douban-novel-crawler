# douban-novel-crawler
豆瓣文学小说的爬虫，框架用到了Quartz和线程池，爬虫则是HttpClient和Jsoup

> 启动类方法：QuartzMaster.runIt(String task,int task_count,String crawler,int thread_count,String cron);

- task:任务模型
- task_count:每次任务量
- crawler:爬取线程
- thread_count:线程数
- cron:时间调度
