package org.example.students;

import java.util.*;

public class ExaminationImpl implements Examination {

    private final Map<String, Score> items = new HashMap<> ();
    private int calls = 0;
    @Override
    public void addScore(Score score) {
        items.put(score.id(),score);

    }

    @Override
    public Score getScore(String id) throws ItemNotFoundException {
            Score score = items.get(id);
            if (score == null) {
                throw new ItemNotFoundException(id);
            }
            return score;
    }

    @Override
    public double getAverageForSubject(String subject, int score) {
        calls++;
        Score nameSubject = items.get(subject);
        double result = 0;
        result+=score;
        result=result/calls;
        return result;

    }



    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        Set<String> names = new HashSet<>();
        for (Score score : getAllScores().values()) {
            names.add(score.name());
        }

        return names;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Set<String> names = new HashSet<>();
        for (Score score : getAllScores().values()) {
            names.add(score.name());
        }

        return names;
    }

    @Override
    public Map<String, Score> getAllScores() {
        return new HashMap<>(items);
    }
}
