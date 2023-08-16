package org.example.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

public class ExaminationTest {
    private Examination examination;
    private int calls = 0;
    @BeforeEach
    void setUp(){
        examination = new ExaminationImpl();
    }
    @Test
    void addScore() throws ItemNotFoundException {
    Score score = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 2);
    examination.addScore(score);
        Score actual = examination.getScore(score.id());
        Assertions.assertEquals(score,actual);
    }

    @Test
    void getScore() throws ItemNotFoundException {
        Assertions.assertThrows(ItemNotFoundException.class, ()-> examination.getScore(UUID.randomUUID().toString()));
    }

    @Test
    void getAverageForSubject() {
        Score student1 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 2);
        Score student2 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 3);
        Score student3 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 5);
        examination.addScore(student1);
        examination.addScore(student2);
        examination.addScore(student3);


    }

    @Test
    void multipleSubmissionsStudentNames() {
        calls ++;
        Score student1 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 2);
        Score student2 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 3);
        Score student3 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 5);
        examination.addScore(student1);
        examination.addScore(student2);
        examination.addScore(student3);

    }

    @Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Score student1 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 2);
        Score student2 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 3);
        Score student3 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 5);
        examination.addScore(student1);
        examination.addScore(student2);
        examination.addScore(student3);
    }

    @Test
    void getAllScores() {
        Score student1 = new Score(UUID.randomUUID().toString(),"Вася", "Петров", "математика" , 2);
        Score student2 = new Score(UUID.randomUUID().toString(),"Петя", "Петров", "математика" , 3);
        Score student3 = new Score(UUID.randomUUID().toString(),"Тема", "Петров", "математика" , 5);
        examination.addScore(student1);
        examination.addScore(student2);
        examination.addScore(student3);
        Map<String, Score> allStudents = examination.getAllScores();
        Assertions.assertEquals(5,allStudents.size());

    }
}
