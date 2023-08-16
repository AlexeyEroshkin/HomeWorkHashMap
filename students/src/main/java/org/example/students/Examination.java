package org.example.students;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Examination {
    void addScore(Score score);

    Score getScore(String id) throws ItemNotFoundException;

    double getAverageForSubject(String subject, int score);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

   Map <String, Score> getAllScores();
}
