package hw4;

import java.util.ArrayList;

/**
 * Palindrome tespitinde kullanmak için stack bazlı sınıftır.
 *
 * @author Zeki ÇIPLAK
 * @version 1.0
 */
public class MyStack {
  private ArrayList<Character> stack;
  private int top = -1;

  /**
   * MyStack nesnelerini oluşturan consturctor.
   *
   */
  public MyStack() {
    stack = new ArrayList<>();
  }

  /**
   * Stack nesnesine yeni eleman eklemek için kullanılan metottur.
   *
   * @param harf stack'e eklenecek char veri tipinde harf.
   */
  public void push(char harf) {
    stack.add(++top, harf);
  }

  /**
   * Stack nesnesinden eleman çıkartmak için kullanılan metottur.
   *
   * @return stack'ten çıkarılan elemanı char veri tipinde döndürür.
   */
  public char pop() {
    return stack.remove(top--);
  }
}
