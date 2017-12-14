package com.soccer.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.soccer.domain.Player;
import com.soccer.service.RegisterService;

@Controller
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({
	@Result(name="getPlayers", location="/admin/ListPlayers.jsp"),
	@Result(name="input", type="redirect", location="/Index.jsp")
})
public class ListPlayersAction {

	@Resource
	private RegisterService registerServcie;
	
	private List<Player> players;
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Action("getPlayersAction")
	public String players(){
		try {
			players = registerServcie.getPlayers();
			/*for(Player p : players){
				System.out.println(p);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		return "getPlayers";
	}
	
}
