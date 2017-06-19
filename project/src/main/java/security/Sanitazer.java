package security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sanitazer {
	public boolean inputCheck(String str) {
		String str1 = "select|insert|delete|from| count\\(|drop table| updateTruncate| asc\\(mid\\(   |char\\(|xp_cmdshell| exec master| netlocalgroup administrators|| : | net user| \\“ \\“ | or| and";

		Pattern r = Pattern.compile(str1);
		String str2 = "[-|;|,|\\/|\\(|\\)|\\[|\\]|\\}|\\{|%|@|\\*|!|\\’}";

		Pattern r2 = Pattern.compile(str2);

		String[] str3 = { "'", " CREATE", " create", " ALTER", " alter", " DROP", " drop", " RENAME", " rename",
				" SELECT", " select", " INSERT", " insert", " UPDATE", " update", " DELETE", " delete", " GRANT",
				" grant", " REVOKE", " revoke", " char", " int", "@@version", "@@VERSION", " exec", " EXEC", " union",
				" UNION", " WAITFOR", " waitfor", " ORDER BY", " order by", ";" };
		for (String s : str3) {
			Pattern r3 = Pattern.compile(s);
			if (r3.matcher(str).matches()) {
				return true;
			}
		}
		return r.matcher(str).matches() || r2.matcher(str).matches();
	}
}
