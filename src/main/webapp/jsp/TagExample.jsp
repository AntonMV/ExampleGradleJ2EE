<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/MyTagDescriptor.tld" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tag:MyTag name="Max"> yohoho ${one}
        <tag:InnerTag></tag:InnerTag>
    </tag:MyTag><br/>
    <myTag:MyJspTags name="Igor">yohoho</myTag:MyJspTags>
    8 - 3 = ${tag:minus(8,3)}

</body>
</html>
