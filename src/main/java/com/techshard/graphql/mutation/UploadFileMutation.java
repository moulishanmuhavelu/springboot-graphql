package com.techshard.graphql.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
        System.out.println("Uploading File");
        Part part = environment.getArgument("filename");

        final DefaultGraphQLServletContext context = environment.getContext();

        context.getFileParts().forEach( part1 -> {

            System.out.println("uploading:" + part.getSubmittedFileName());
        });

/*        try (InputStream ins = part.getInputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String fileContent = br.lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println("fileContent" + fileContent);

        } catch (Exception e) {
            System.err.println("Exception in reading the file");
        }*/

        return UUID.randomUUID();
    }
}
