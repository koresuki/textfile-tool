package com.ke.textfiletool;

import com.ke.textfiletool.controller.ConvertController;
import com.ke.textfiletool.controller.ExtractController;
import com.ke.textfiletool.controller.ReplaceController;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Executor {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String parentPath = path.substring(0,path.lastIndexOf("\\"));
        try {
            if (args.length != 1){
                throw new Exception("No input param");
            }
            if (args[0].equals(OperateType.Replace.getCode())) {
                ReplaceController replaceController =new ReplaceController();
                log.info("Current path :{}", parentPath);

                replaceController.replace(parentPath);
            } else if (args[0].equals(OperateType.MdToHtml.getCode())) {
                ConvertController convertController =new ConvertController();
                log.info("Current path :{}", parentPath);
                convertController.BatchMdToHtml(parentPath);
            }else if (args[0].equals(OperateType.PdfExtract.getCode())){
                log.info("Current path :{}", parentPath);
                ExtractController extractController=new ExtractController();
                extractController.ExtractPdfHighlight(parentPath);
            } else {
                throw new Exception("Invalid operateType");
            }
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
    }



}