package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldGetSimpleTasksData() {
        SimpleTasks simpleTask = new SimpleTasks(7, "Сходить в гости");

        Assertions.assertEquals(7, simpleTask.getId());
        Assertions.assertEquals("Сходить в гости", simpleTask.getTitle());
    }

    @Test
    public void shouldGetEpicData() {
        String[] subtasks = {"Купить корм собаке", "Приготовить обед"};
        Epic epic = new Epic(8, subtasks);

        Assertions.assertEquals(8, epic.getId());
        String[] expected = {"Купить корм собаке", "Приготовить обед"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMeetingData() {
        Meeting meeting = new Meeting(27, "Позвонить коллегам", "Встретить друга", "30 декабря");

        Assertions.assertEquals(27, meeting.getId());
        Assertions.assertEquals("Позвонить коллегам", meeting.getTopic());
        Assertions.assertEquals("Встретить друга", meeting.getProject());
        Assertions.assertEquals("30 декабря", meeting.getStart());
    }

    @Test
    public void testSimpleTasksMatches() {
        SimpleTasks simpleTask = new SimpleTasks(7,"Помыть машину");

        Assertions.assertEquals(true, simpleTask.matches("машину"));
        Assertions.assertEquals(false, simpleTask.matches("окна"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"покормить собаку", "приготовить ужин", "полить цветы"};
        Epic epic = new Epic(33, subtasks);

        Assertions.assertEquals(true, epic.matches("цветы"));
        Assertions.assertEquals(false, epic.matches("машину"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(47,
                "Выполнение домашнего задания",
                "Netology",
                "17 октября");

        Assertions.assertEquals(true, meeting.matches("Выполнение"));
        Assertions.assertEquals(true, meeting.matches("Netology"));
        Assertions.assertEquals(false, meeting.matches("телевизор"));

    }
}
