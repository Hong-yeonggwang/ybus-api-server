//package com.ybus.ybusapiserver.Service.menu;
//
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.lang.model.type.ArrayType;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Service
//public class MenuService {
//    private String csvFile = "src/main/resources/menuFile/menu.csv";
//    private String line;
//    private String cvsSplitBy = "\t";
//
//    private List<List<Character>> textList = new ArrayList<>();
//
//    private List<String> data = new ArrayList<>();
//
//    private List<List<String>> lastList = new ArrayList<>();
//
//    private List<List<String>> toJsonList = new ArrayList<>();
//
//    private int check = 0;
//
//    private Map<String, Map<String, String>> menuItems = new HashMap<>();
//
//    @PostConstruct
//    public void parseMenuData() {
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            List<String> lines = new ArrayList<>();
//            while ((line = br.readLine()) != null) {
//                List<Character> charList = line.chars()
//                        .mapToObj(c -> (char) c)
//                        .collect(Collectors.toList());
//                textList.add(charList);
//            }
//
//            System.out.println("--------------");
//            System.out.println(textList.size());
//            System.out.println("--------------");
//            textList.forEach(name -> System.out.println(name));
//
//            for(int i = 0; i< textList.size(); i++){
//                for(int j = 0; j<textList.get(i).size(); j++){
//                    if(textList.get(i).get(j) == '\"'){check++;}
//                }
//                if(check % 2 == 1){
//                    textList.get(i).remove(textList.get(i).size() -1); //마지막 \n삭제
//                    List<Character> temp = textList.get(i+1); // 다음줄 가져오기
//                    for(Character one : temp){
//                        textList.get(i).add(one);
//                    }
//                    textList.remove(i+1);
//                    check = 0;
//                    i--;
//                }
//            }
//
//            System.out.println("--------------");
//            System.out.println(textList.size());
//            System.out.println("--------------");
//            textList.forEach(name -> System.out.println(name.toString()));
//
//
//
//            for(List<Character> charList : textList){
//                StringBuilder sb = new StringBuilder();
//                for (char c : charList) {
//                    sb.append(c);
//                }
//                String result = sb.toString();
//                data.add(result);
//            }
//
//            System.out.println("--------------");
//            System.out.println(data.size());
//            System.out.println("--------------");
//
//            data.forEach(name -> System.out.println(name));
//
//            for(int i = 0; i < data.size(); i++){
//                String[] tokens = data.get(i).split(",");
//
//                List<String> list = new ArrayList<>();
//                list.addAll(Arrays.asList(tokens));
//                lastList.add(list);
//            }
//
//            lastList.subList(0, 2).clear();
////            lastList.forEach(name -> System.out.println(name));
//
//
//            List<Integer> sizeList = new ArrayList<>();
//
//            System.out.println("--------------");
//            System.out.println(lastList.size());
//            System.out.println("--------------");
//
//            for(int i  = 0; i<lastList.size(); i++){
//                if(lastList.get(i).size() > 2){
//                    if(lastList.get(i).get(1) != null){
//                        System.out.println(lastList.get(i).get(1));
//                        sizeList.add(i);
//                    }
//                }
//            }
//
////            sizeList.forEach(name -> System.out.println(name));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
