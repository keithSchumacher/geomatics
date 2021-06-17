package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Result;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.ModuleService;
import com.udacity.jwdnd.course1.cloudstorage.services.ResultService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ResultService resultService;
    @Autowired
    ModuleService moduleService;
    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getHomePage(Authentication authentication, Model model) {
        model.addAttribute("results",
                resultService.getResults());
        model.addAttribute("modules",
                moduleService.getModules());
        return "home";
    }

    @GetMapping(path = {"*", "home/*" })
    public String defaultHome(){
        return "redirect:/home";
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(Authentication authentication, RedirectAttributes redirectAttributes,
                                                            String resultId,
                                                            HttpServletResponse response) throws IOException {
            Result result = resultService.getResult(Integer.valueOf(resultId));
            redirectAttributes.addFlashAttribute("success", "File was downloaded.");
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + "output.txt")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(new ByteArrayInputStream(result.getOutput())));
        }

    @PostMapping(path = "/create_module")
    public String createModule(Authentication authentication,
                             @RequestParam(name="moduleId", required=false) Integer moduleId,
                             @RequestParam("moduleName") String moduleName,
                             @RequestParam("gitURL") String gitURL,
                             RedirectAttributes redirectAttributes) {
        int rowsAdded = -1;
        if (moduleId == null) {
            rowsAdded = moduleService.createModule(moduleName, gitURL,
                    userService.getUserId(authentication.getName()));
            redirectAttributes.addFlashAttribute("note_success", "Note was created.");
        }
//        else {
//            rowsAdded = moduleService.updateNote(noteid, moduleName, gitURL);
//            redirectAttributes.addFlashAttribute("note_success", "Note was updated.");
//        }
        if (rowsAdded < 0) {
            System.out.println("there was an error inserting the note");
        }  else {
            redirectAttributes.addFlashAttribute("notes",
                    moduleService.getModules());
//                            this.userService.getUserId(authentication.getName())));
            redirectAttributes.addFlashAttribute("tab", "note");
        }
        return "redirect:/home";
    }




//        @GetMapping("/delete_file")
//        public String deleteFile(Authentication authentication, String fileId, RedirectAttributes redirectAttributes) {
//        this.fileService.deleteFile(Integer.valueOf(fileId));
//        redirectAttributes.addFlashAttribute("file_success", "File was deleted.");
//        redirectAttributes.addFlashAttribute("tab", "file");
//            return "redirect:/home";

//        }



//    @PostMapping(path = "/upload", params = "upload-file")
//    public String fileUpload(Authentication authentication,
//                             @RequestParam("webfile") MultipartFile webfile, RedirectAttributes redirectAttributes) {
//        String uploadError = null;
//        uploadError = this.fileService.isFileValid(webfile, authentication.getName());
//        if (uploadError == null) {
//            int rowsAdded = this.fileService.createFile(webfile, this.userService.getUserId(authentication.getName()));
//            if (rowsAdded < 0) {
//                uploadError = "There was an error uploading the file. Please try again.";
//            } else {
//                redirectAttributes.addFlashAttribute("files",
//                        this.fileService.getFiles(this.userService.getUserId(authentication.getName())));
//                redirectAttributes.addFlashAttribute("file_success", "File was successfully uploaded.");
//                redirectAttributes.addFlashAttribute("tab", "file");
//            }
//        }
//        if (uploadError != null) {redirectAttributes.addFlashAttribute("uploadError", uploadError);}
//            return "redirect:/home";

//        }
}

