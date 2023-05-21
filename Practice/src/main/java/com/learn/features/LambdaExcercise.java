package com.learn.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExcercise {
//https://github.com/shekhargulati/java8-the-missing-tutorial/blob/master/02-lambdas.md
	public static void main(String[] args) {
        List<Task> tasks = null;//getTasks();
        List<String> titles = taskTitles(tasks, task -> task.getType() == TaskType.READING);
        titles.forEach(System.out::println);
    }

    public static List<String> taskTitles(List<Task> tasks, Predicate<Task> filterTasks) {
        List<String> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (filterTasks.test(task)) {
                readingTitles.add(task.getTitle());
            }
        }
        return readingTitles;
    }
	
}


