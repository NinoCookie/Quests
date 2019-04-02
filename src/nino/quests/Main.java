package nino.quests;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import nino.quests.commands.QuestCmd;
import nino.quests.listeners.OnClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public static Economy economy;
    public static Permission permission;

    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().isPluginEnabled("NJobs")){
            Bukkit.getConsoleSender().sendMessage("Jobs plugin detected!");
        }
        createconfig();
        setupEconomy();
        setupPermissions();
        OnClick onClick=new OnClick(this);
        Bukkit.getPluginManager().registerEvents(onClick, this);
        QuestCmd questCmd=new QuestCmd();
        Bukkit.getPluginCommand("Quests").setExecutor(questCmd);
    }

    private boolean setupEconomy(){
        if(getServer().getPluginManager().getPlugin("Vault")==null){
            return false;
        }
        RegisteredServiceProvider<Economy> rsp= getServer().getServicesManager().getRegistration(Economy.class);
        if(rsp==null){
            return false;
        }
        economy=rsp.getProvider();
        return true;
    }

    private boolean setupPermissions(){
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    public void createconfig(){
        File file=new File(getDataFolder()+File.separator+"config.yml");
        if(!file.exists()){
            this.saveDefaultConfig();
        }
        else{
            this.reloadConfig();
        }
    }

}
