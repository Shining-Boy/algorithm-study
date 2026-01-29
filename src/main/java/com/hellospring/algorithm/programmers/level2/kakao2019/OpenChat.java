package com.hellospring.algorithm.programmers.level2.kakao2019;

import java.util.*;

public class OpenChat {
    final String Enter = "Enter";
    final String Leave = "Leave";
    final String Change = "Change";

    static class ActionLog {
        String action, uuid;

        ActionLog(String action, String uuid) {
            this.action = action;
            this.uuid = uuid;
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> idNameMap = new HashMap<>();
        List<ActionLog> actionList = new ArrayList<>();
        for (String s : record) {
            String[] parseStr = s.split(" ");
            String action = parseStr[0];
            String id = parseStr[1];
            String name = "";

            switch (action) {
                case Enter:
                    name = parseStr[2];
                    idNameMap.put(id, name);
                    actionList.add(new ActionLog(action, id));
                    break;
                case Leave:
                    actionList.add(new ActionLog(action, id));;
                    break;
                case Change:
                    name = parseStr[2];
                    idNameMap.put(id, name);
                    break;
            }
        }

        String[] answer = new String[actionList.toArray().length];
        for (int i=0; i<answer.length; i++)
        {
            ActionLog actionLog = actionList.get(i);
            String actionDesc = actionLog.action.equals(Enter) ? "님이 들어왔습니다." : "님이 나갔습니다.";
            String nickName = idNameMap.get(actionLog.uuid);
            answer[i] = nickName + actionDesc;
        }


        return answer;
    }

    public static void main(String[] args) {
        OpenChat f = new OpenChat();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                            "Leave uid1234","Enter uid1234 Prodo",
                            "Change uid4567 Ryan"};

        String[] result = f.solution(record);
        System.out.println("result = " + Arrays.toString(result));
    }
}
