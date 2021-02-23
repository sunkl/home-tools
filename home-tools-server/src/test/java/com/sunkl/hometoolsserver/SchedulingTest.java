package com.sunkl.hometoolsserver;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class SchedulingTest implements SchedulingConfigurer {
    private static String cron = "0/5 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(() -> {
            // 任务逻辑
            System.out.println("dynamicCronTask is running...");
        }, triggerContext -> {
            // 任务触发，在这里可修改任务的执行周期,因为每次调度都会执行这里
            CronTrigger cronTrigger = new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }

    public void SpringDynamicCronTask() {
        //模拟业务修改周期,可以在具体业务中修改参数cron
        new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cron = "0/2 * * * * ?";
        }).start();
    }
}
