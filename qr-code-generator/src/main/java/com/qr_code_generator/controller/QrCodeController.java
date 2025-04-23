package com.qr_code_generator.controller;

import com.google.zxing.WriterException;
import com.qr_code_generator.service.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api/qr")
public class QrCodeController {

    private final QrCodeService qrCodeService = new QrCodeService();

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> generateQRCode(@RequestParam String text) {
        try {
//            String url = "http://localhost:8080/api/qr/view?text=" +
//                    URLEncoder.encode(text, StandardCharsets.UTF_8);
            BufferedImage image = qrCodeService.generateQRCodeWithText(text);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);
            return ResponseEntity.ok(out.toByteArray());
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/view")
    public String viewPage(@RequestParam String text, Model model) {
        model.addAttribute("message", text);
        return "qrview";
    }

}
