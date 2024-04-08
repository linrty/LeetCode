package s2512;

import java.util.*;

public class Solution{
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        String s1 = "this student is ";
        int len1 = s1.length();
        int report_len = report.length;
        Queue<Student> q = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() == o2.getScore()){
                    return o1.getId() - o2.getId();
                }else {
                    return o2.getScore() - o1.getScore();
                }
            }
        });
        Map<String,Integer>m = new HashMap<>();
        for (String str:positive_feedback) {
            m.put(str,3);
        }
        for (String str:negative_feedback) {
            m.put(str,-1);
        }
        for (int i = 0;i < report_len;i++) {
            String[] s3 = report[i].split(" ");
            Student stu = new Student();
            stu.setId(student_id[i]);
            stu.setScore(0);
            for (String str1:s3) {
                stu.setScore(stu.getScore() + m.getOrDefault(str1,0));
            }
            q.add(stu);
        }
        List<Integer> res = null;
        res = new ArrayList<>();
        for (int i = 0;i < k;i++){
            Student stu = q.poll();
            res.add(stu.getId());
            System.out.println(stu.getId() + " " + stu.getScore());
        }
        return res;
    }
}
class Student{
    int id;
    int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
