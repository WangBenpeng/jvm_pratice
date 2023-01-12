package com.pengo.jvm_pratice.chapter10;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author Benpeng
 * @date 2023/1/3
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class NameCheckProcessor extends AbstractProcessor {

    private com.pengo.jvm_pratice.chapter10.NameChecker nameChecker;

    public void init(ProcessingEnvironment processingEnv) { super.init(processingEnv);
        nameChecker = new com.pengo.jvm_pratice.chapter10.NameChecker(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements())
                nameChecker.checkNames(element);
        }
        return false;
    }
}
