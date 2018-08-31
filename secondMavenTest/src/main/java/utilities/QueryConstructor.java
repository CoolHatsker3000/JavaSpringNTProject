package utilities;

import mappers.TabMapper;

public class QueryConstructor {
    private static String getWhereStatement(String[] columns){
        StringBuilder builder=new StringBuilder(" WHERE ");
        for (String col:
                columns){
            builder.append(col.concat("=? and "));
        }
        builder.setLength(builder.length()-4);
        return builder.toString();
    }
    public static String getInsert(TabMapper tab){
        StringBuilder builder=new StringBuilder("INSERT INTO ");
        builder.append(tab.getTabName());
        builder.append(" VALUES (");
        int rowLen=tab.getColumns().length+tab.getIdColumns().length-1;
        for (int i=0;i<rowLen;i++){
            builder.append("?, ");
        }
        builder.append("?)");
        return builder.toString();
    }
    public static String getSelectAll(TabMapper tab){
        return "SELECT * FROM ".concat(tab.getTabName());
    }
    public static String getSelectByID(TabMapper tab){
        StringBuilder builder=new StringBuilder("SELECT * FROM ".concat(tab.getTabName()));
        builder.append(getWhereStatement(tab.getIdColumns()));
        return builder.toString();
    }
    public static String getDelete(TabMapper tab){
        return "DELETE FROM ".concat(tab.getTabName()).concat(getWhereStatement(tab.getIdColumns()));
    }
    public static String getUpdate(TabMapper tab){
        StringBuilder builder=new StringBuilder("UPDATE ".concat(tab.getTabName()).concat(" SET "));
        for (String col:
             tab.getColumns()) {
            builder.append(col.concat("=?,"));
        }
        builder.setLength(builder.length()-1);
        builder.append(getWhereStatement(tab.getIdColumns()));
        return builder.toString();
    }
    public static String getSelect(TabMapper tab){
        StringBuilder builder=new StringBuilder("SELECT * FROM ");
        builder.append(tab.getTabName());
        builder.append(getWhereStatement(tab.getColumns()));
        return builder.toString();
    }

}
