package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.ModuleOutput;
import com.udacity.jwdnd.course1.cloudstorage.services.ModuleOutputService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
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
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {
    private ModuleOutputService moduleOutputService;
    private UserService userService;

    public HomeController(ModuleOutputService moduleOutputService, UserService userService) {
        this.userService = userService;
        this.moduleOutputService = moduleOutputService;
    }

    @GetMapping("/home")
    public String getHomePage(Authentication authentication, Model model) {
        model.addAttribute("moduleOutputs",
                this.moduleOutputService.getModuleOutputs());
        return "home";
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(Authentication authentication, RedirectAttributes redirectAttributes,
                                                            String moduleId,
                                                            HttpServletResponse response) throws IOException {
            ModuleOutput moduleOutput = this.moduleOutputService.getModuleOutput(Integer.valueOf(moduleId));
            redirectAttributes.addFlashAttribute("success", "File was downloaded.");
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + "output.txt")
//                    .contentLength(file.getFilesize())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(new ByteArrayInputStream(moduleOutput.getOutput())));
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

    @GetMapping(path = {"*", "home/*" })
    public String defaultHome(){
        return "redirect:/home";
    }
}

