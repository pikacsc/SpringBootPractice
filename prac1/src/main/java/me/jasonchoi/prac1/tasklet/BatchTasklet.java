package me.jasonchoi.prac1.tasklet;

import me.jasonchoi.prac1.service.UserService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchTasklet implements Tasklet {

    @Autowired
    private UserService userService;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println(chunkContext.getStepContext().getJobParameters().get("jobName").toString());
        userService.userList();
        Thread.sleep(10000);
        return RepeatStatus.FINISHED;
    }
}
