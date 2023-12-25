package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTasks simpleTask = new SimpleTasks(5, "Встретить жену");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                47,
                "Выход нового сезона сериала",
                "Сериал Netflix",
                "В субботу вечером"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereHaveMatch() {
        SimpleTasks simpleTask = new SimpleTasks(13, "Помыть окна");

        String[] subtasks = {"Купить котенка дочери", "Отнести джинсы в ремонт"};
        Epic epic = new Epic(69, subtasks);

        Meeting meeting = new Meeting(77, "Блог уроков", "Забрать новые джинсы", "26 августа");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("джинсы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereDoNotHaveMatch() {
        SimpleTasks simpleTask = new SimpleTasks(87, "Помыть окна");

        String[] subtasks = {"Купить котенка дочери", "Отнести джинсы в ремонт"};
        Epic epic = new Epic(69, subtasks);

        Meeting meeting = new Meeting(77, "Блог уроков", "Забрать новые джинсы", "26 августа");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("собака");
        Assertions.assertArrayEquals(expected, actual);
    }
}
