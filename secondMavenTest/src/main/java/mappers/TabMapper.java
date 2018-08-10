package mappers;

public class TabMapper {
    private final String tabName;
    private final String[] idColumns;
    private final String[] columns;

    public TabMapper(String tabName, String[] idColumns, String[] columns) {
        this.tabName = tabName;
        this.idColumns = idColumns;
        this.columns = columns;
    }

    public String getTabName() {
        return tabName;
    }

    public String[] getIdColumns() {
        return idColumns;
    }

    public String[] getColumns() {
        return columns;
    }
}
