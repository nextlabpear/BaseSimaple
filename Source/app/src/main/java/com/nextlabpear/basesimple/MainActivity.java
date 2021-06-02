package com.nextlabpear.basesimple;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mMainTreeBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainTreeBtn = findViewById(R.id.main_treeBtn);
        mMainTreeBtn.setOnClickListener(this);

        bound();
    }




    public int solution4(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Item> queue = new PriorityQueue<>(Collections.reverseOrder());
        for( int i = 0; i< priorities.length; i++){
            queue.add( new Item( i , priorities[i]));
        }


        int index = 0;
        Item top = queue.poll();
        while (answer < priorities.length){
            if(priorities[index] == top.prior) {
                answer++;
                priorities[index] = 0;
                top = queue.poll();
                if(location == index)
                    return answer;
            }
            index++;
            index = index  % priorities.length;
        }


        return answer;
    }

    class Item implements Comparable<Item>{
        public int location;
        int prior;
        public Item( int location, int prior){
            this.location = location;
            this.prior = prior;
        }

        public int getLocation() {
            return location;
        }

        public int getPrior() {
            return prior;
        }

        @Override
        public int compareTo(Item o) {
            return this.prior > o.prior ? 1 : -1;
        }
    }

    public int[] solution3(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.add( (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i]  :
                    (100 - progresses[i]) / speeds[i]  + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int cnt = 1;
        int pre = queue.poll();
        while (!queue.isEmpty()){
            int current = queue.poll();

            if( pre < current)
            {
                result.add(cnt);
                cnt = 1;
                pre = current;

            }
            else{
                cnt++;
            }
        }
        result.add(cnt);

        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for( int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[completion.length];
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort( phone_book );
        for( int i = 0; i <phone_book.length-1; i++){
            if( phone_book[i+1].startsWith(phone_book[i]))
                return false;

        }


        return answer;
    }


    @Override
    public void onClick(View v) {

        Intent nIntent = new Intent();

        switch (v.getId()) {
            case R.id.main_treeBtn:
                nIntent.setClass(getApplicationContext(), TreeActivity.class);
                startActivity(nIntent);
                break;
        }


    }

    public void linked(){
        LinkedList<Integer> linked = new LinkedList<>();
    }

    public void thread() {
        ExecutorService mExecutor = Executors.newFixedThreadPool(2);
        mExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });


    }



    public void bound() {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int nErrorCnt = 0;
        int nSucess = 0;
        int test = 0;

        Stack<Character> stack = new Stack<>();
        stack.push('s');
        String aaa = "}{}{}{}{}{}{}{}{})()(){(}){(}){(}){()}{()}(){(}){(})[][][][][][()()()()[][][][]";

        for(Character str : aaa.toCharArray()) {
            //Log.d("bound", String.format("str %c", str));
            if( map.containsValue( str ) ) {
                test++;
                stack.push(str);
            }
            else {

                Character peek = stack.peek();
                if( peek.equals(map.get(str))){
                    nSucess++;
                    stack.pop();
                }
                else{
                    nErrorCnt++;
                    //[Todo] fail return;
                }
            }
        }
        Log.d("bound", String.format("test %d", test));
        Log.d("bound", String.format("input len %d", aaa.length()));
        Log.d("bound", String.format("nSucess(%d)", nSucess));
        Log.d("bound", String.format("nErrorCnt(%d)", nErrorCnt));
        Log.d("bound", String.format("stack.size(%d)", stack.size()));
    }


    public void intent(){
        Intent nIntent = new Intent(this.getApplicationContext(), SubSaimpleActivity.class);
        nIntent.putExtra("key", "value");
        startActivity(nIntent);
    }


    final Handler mHandlerRefresh = new Handler( Looper.getMainLooper());
    public void postDelay(){
        mHandlerRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 3000);
    }

    public void uiThread(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}