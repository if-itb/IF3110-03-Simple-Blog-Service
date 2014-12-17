/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class Coba {
    public static void main(String[] args) {
        SimpleBlogService blog = new SimpleBlogServiceImplementation();
        
        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);
        
        while (true) {
            out.println("Pilih satu:");
            out.println("0: Exit");
            out.println("1: Add Post");
            out.print("> ");
            
            int pilihan = Integer.parseInt(in.nextLine());
            if (pilihan == 0) {
                break;
            }
            else if (pilihan == 1) { // Add Post
                String judul, konten, tanggal;
                out.print("Judul   : ");
                judul = in.nextLine();
                out.print("Konten  : ");
                konten = in.nextLine();
                out.print("Tanggal : ");
                tanggal = in.nextLine();
                
                boolean result = blog.addPost(judul, konten, tanggal);
                out.println("Hasil: " + result);
            }
        }
    }
}
