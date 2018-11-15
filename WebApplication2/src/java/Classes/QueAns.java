package Classes;


import java.util.ArrayList;
import java.util.HashMap;



public class QueAns 
{
  public  int q_id;
  public  String question;
  public  int a_id;
  public  ArrayList<Integer> ans_id;
  public  ArrayList<String> answer;
  public  ArrayList<Boolean> status;

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public ArrayList<Integer> getAns_id() {
        return ans_id;
    }

    public void setAns_id(ArrayList<Integer> ans_id) {
        this.ans_id = ans_id;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public ArrayList<Boolean> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<Boolean> status) {
        this.status = status;
    }
    
    
}
