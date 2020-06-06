package com.example.assignment.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FeedModelTest {
private FeedModel feedModel;


@Before
    public void initMocks(){

    feedModel=mock(FeedModel.class);
    feedModel.setTitle("title");
    feedModel.setDescription("description");
    feedModel.setImageHref("http://worldofplay.co.in/img.png");
    feedModel.setHeader_title("header_title");
}

@Test
public void validFeedEntry()
{
    createMockFeedModel();
}

private void createMockFeedModel(){
    when(feedModel.getTitle()).thenReturn("title");
    when(feedModel.getDescription()).thenReturn("description");
    when(feedModel.getImageHref()).thenReturn("http://worldofplay.co.in/img.png");
    when(feedModel.getHeader_title()).thenReturn("header_title");
}

}