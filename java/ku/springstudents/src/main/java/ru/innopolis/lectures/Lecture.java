package ru.innopolis.lectures;

public class Lecture {
  private Long lectureId;
  private java.sql.Date date;
  private String subject;

  public Long getLectureId() {
    return lectureId;
  }

  public void setLectureId(Long lectureId) {
    this.lectureId = lectureId;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
