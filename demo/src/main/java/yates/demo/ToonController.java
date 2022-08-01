package yates.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ToonController {
    private static Map<Integer, Toon> toonRepo = new HashMap<>();
    static {
        Toon upsidedown = new Toon();
        upsidedown.setAvialable(true);
        upsidedown.setDate(2011);
        upsidedown.setId(1);
        upsidedown.setName("The upsidedown show");
        toonRepo.put(upsidedown.getId(), upsidedown);

        Toon MasterChief = new Toon();
        MasterChief.setAvialable(true);
        MasterChief.setDate(2010);
        MasterChief.setId(2);
        MasterChief.setName("Halo");
        toonRepo.put(MasterChief.getId(), MasterChief);

        Toon Spongebob = new Toon();
        Spongebob.setName("Spongebob");
        Spongebob.setId(3);
        Spongebob.setDate(2003);
        Spongebob.setAvialable(true);
        toonRepo.put(Spongebob.getId(), Spongebob);
    }
    @RequestMapping(value= "/toon")
    public ResponseEntity<Object> gettoons(){
        return new ResponseEntity<>(toonRepo.values(), HttpStatus.OK);
    }

}

